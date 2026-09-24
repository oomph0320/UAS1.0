const fs = require('fs');

function escapeStr(s) {
  return (s || '')
    .replace(/\\/g, '\\\\')
    .replace(/"/g, '\\"')
    .replace(/\n/g, '\\n')
    .replace(/\r/g, '');
}

const data = JSON.parse(fs.readFileSync('counter_uas_200.json', 'utf-8'));

let kt = `package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val counterUasQuestions: List<Question> = listOf(
`;

data.forEach((q, idx) => {
  kt += `    Question(
        id = "${q.id}",
        type = QuestionType.${q.type.toUpperCase()},
        question = "${escapeStr(q.question)}",
`;
  if (q.options && q.options.length > 0) {
    kt += '        options = listOf(\n';
    q.options.forEach(opt => {
      kt += `            QuizOption("${escapeStr(opt.key)}", "${escapeStr(opt.text)}"),\n`;
    });
    kt += '        ),\n';
  } else {
    kt += '        options = emptyList(),\n';
  }
  const ansStr = q.answer.map(a => `"${escapeStr(a)}"`).join(', ');
  kt += `        answer = listOf(${ansStr}),
        explanation = "${escapeStr(q.explanation)}",
        topic = "${escapeStr(q.topic)}",
        difficulty = ${q.difficulty}
    )${idx < data.length - 1 ? ',\n' : '\n'}`;
});

kt += ');\n';

fs.writeFileSync('./app/src/main/java/com/example/data/initial/CounterUasQuestions.kt', kt);
console.log('Successfully written CounterUasQuestions.kt with', data.length, 'questions');
