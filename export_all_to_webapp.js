const fs = require('fs');

// 读取已有 extracted_questions.json (原来无人机技术基础的145道题)
const existingQuestions = JSON.parse(fs.readFileSync('extracted_questions.json', 'utf-8'));

// 读取 5 个模块的 JSON 文件
const cuas = JSON.parse(fs.readFileSync('counter_uas_200.json', 'utf-8'));

// 从刚才创建的 4 个 kotlin 文件或重新解析生成统一格式
// 为了保证完全一致，我们直接用 require 或者读取并转换为标准前端格式
function parseKtQuestions(filename) {
  const content = fs.readFileSync(`./app/src/main/java/com/example/data/initial/${filename}.kt`, 'utf-8');
  const questions = [];
  
  const qBlocks = content.split('Question(\n');
  qBlocks.shift(); // remove header
  
  qBlocks.forEach(block => {
    const idMatch = block.match(/id\s*=\s*"([^"]+)"/);
    const typeMatch = block.match(/type\s*=\s*QuestionType\.([A-Z]+)/);
    const qMatch = block.match(/question\s*=\s*"((?:\\.|[^"\\])*)"/);
    const ansMatch = block.match(/answer\s*=\s*listOf\(([^)]*)\)/);
    const expMatch = block.match(/explanation\s*=\s*"((?:\\.|[^"\\])*)"/);
    const topicMatch = block.match(/topic\s*=\s*"([^"]+)"/);
    const diffMatch = block.match(/difficulty\s*=\s*(\d+)/);
    
    if (idMatch && typeMatch && qMatch) {
      const id = idMatch[1];
      const type = typeMatch[1].toLowerCase();
      const question = qMatch[1].replace(/\\"/g, '"').replace(/\\\\/g, '\\').replace(/\\n/g, '\n');
      const topic = topicMatch ? topicMatch[1] : '综合';
      const explanation = expMatch ? expMatch[1].replace(/\\"/g, '"').replace(/\\\\/g, '\\').replace(/\\n/g, '\n') : '';
      const difficulty = diffMatch ? parseInt(diffMatch[1]) : 2;
      
      // parse options
      const options = [];
      const optRegex = /QuizOption\("([^"]+)",\s*"((?:\\.|[^"\\])*)"\)/g;
      let optM;
      while ((optM = optRegex.exec(block)) !== null) {
        options.push({
          key: optM[1],
          text: optM[2].replace(/\\"/g, '"').replace(/\\\\/g, '\\').replace(/\\n/g, '\n')
        });
      }
      
      // parse answers
      const answers = [];
      if (ansMatch) {
        const rawAns = ansMatch[1];
        const aRegex = /"((?:\\.|[^"\\])*)"/g;
        let aM;
        while ((aM = aRegex.exec(rawAns)) !== null) {
          answers.push(aM[1].replace(/\\"/g, '"').replace(/\\\\/g, '\\'));
        }
      }
      
      questions.push({
        id,
        type,
        question,
        options,
        answer: answers,
        explanation,
        topic,
        difficulty
      });
    }
  });
  
  return questions;
}

const radar = parseKtQuestions('RadarQuestions');
const radio = parseKtQuestions('RadioQuestions');
const opto = parseKtQuestions('OptoelectronicQuestions');
const em = parseKtQuestions('ElectromagneticQuestions');
const uavExpanded = parseKtQuestions('UavFoundationExpandedQuestions');

console.log('Parsed UAV Foundation Expanded:', uavExpanded.length);
console.log('Parsed Radar:', radar.length);
console.log('Parsed Radio:', radio.length);
console.log('Parsed Opto:', opto.length);
console.log('Parsed EM:', em.length);
console.log('CUAS:', cuas.length);
console.log('Existing UAV Base:', existingQuestions.length);

const allWebQuestions = [
  ...existingQuestions,
  ...uavExpanded,
  ...cuas,
  ...radar,
  ...radio,
  ...opto,
  ...em
];

console.log('Total Questions across all modules:', allWebQuestions.length);

// 写入 webapp-dist/embed_questions.js
const embedJs = `// 自动生成的全量大题库 (包含原题库145题 + 无人机技术基础自编重点100题 + 5大拓展学科各200题，共计 ${allWebQuestions.length} 题)
window.DEFAULT_QUESTIONS = ${JSON.stringify(allWebQuestions, null, 2)};
`;

fs.writeFileSync('./webapp-dist/embed_questions.js', embedJs);
fs.writeFileSync('./webapp-dist/questions.json', JSON.stringify(allWebQuestions, null, 2));
console.log('Updated ./webapp-dist/embed_questions.js and ./webapp-dist/questions.json successfully!');
