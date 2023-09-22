const runChat = require('./generateQuestion_export.js'); // chatModule.js 파일을 import

async function main() {
  const questionsData = await runChat();

  if (questionsData) {
    console.log('Questions data:', questionsData);
  } else {
    console.log('An error occurred during chat execution.');
  }
}

main();
