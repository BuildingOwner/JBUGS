const PDFDocument = require("pdf-lib");
const { fromPath } = require("pdf2pic");
const fs = require("fs").promises;

const options = {
  dpi: 100,
  saveFilename: "pic",
  savePath: "./images",
  format: "jpg",
  width: 600,
  height: 600
};

async function getTotalPageCount(pdfPath) {
  const pdfBytes = await PDFDocument.PDFDocument.load(await fs.readFile(pdfPath));
  return pdfBytes.getPageCount();
}

async function convertPdfToImage(pdfPath, pageNumber) {
  const storeAsImage = fromPath(pdfPath, options);

  try {
    await storeAsImage(pageNumber);
    console.log(`Page ${pageNumber} is now converted as an image`);
  } catch (error) {
    console.error(`Error converting PDF page ${pageNumber} to image:`, error);
  }
}

async function convertAllPages(pdfPath) {
  const pageCount = await getTotalPageCount(pdfPath);

  for (let page = 1; page <= pageCount; page++) {
    await convertPdfToImage(pdfPath, page);
  }
}

// 기존 이미지 파일 삭제 후 실행하는 함수
// clearAndConvert 함수를 Promise로 변경하여 완료될 때 resolve를 호출합니다.
async function clearAndConvert(pdfPath) {
  return new Promise(async (resolve, reject) => {
    try {
      await fs.rmdir(options.savePath, { recursive: true });
      await fs.mkdir(options.savePath);
      console.log("Cleared old images and directory created.");
      await convertAllPages(pdfPath);
      console.log("All pages are converted to images.");
      resolve(); // 성공적으로 완료되면 resolve 호출
    } catch (error) {
      console.error("Error:", error);
      reject(error); // 오류 발생 시 reject 호출
    }
  });
}

module.exports = {
  clearAndConvert,
};
