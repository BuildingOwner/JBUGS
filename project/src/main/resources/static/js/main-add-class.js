// const MyClass = [
//   {
//     imgsrc: "/img/sangsangbugi.png",
//     className: "알고리즘",
//     division: "1",
//     prof: "상상부기",
//   },
//   {
//     imgsrc: "/img/sangsangbugi.png",
//     className: "자료구조",
//     division: "A",
//     prof: "상상부기2",
//   },
//   {
//     imgsrc: "/img/sangsangbugi.png",
//     className: "자료구조",
//     division: "A",
//     prof: "상상부기2",
//   },
//   {
//     imgsrc: "/img/sangsangbugi.png",
//     className: "알고리즘",
//     division: "1",
//     prof: "상상부기",
//   },
//   {
//     imgsrc: "/img/sangsangbugi.png",
//     className: "자료구조",
//     division: "A",
//     prof: "상상부기2",
//   },
//   {
//     imgsrc: "/img/sangsangbugi.png",
//     className: "자료구조",
//     division: "A",
//     prof: "상상부기2",
//   },
//   {
//     imgsrc: "/img/sangsangbugi.png",
//     className: "자료구조",
//     division: "A",
//     prof: "상상부기2",
//   },
// ];

const mysql = require('mysql');

const connection = mysql.createConnection({
    host: '13.125.120.116:3306',
    user: 'jbugs',
    password: '1234',
    database: 'webdb'
});

connection.connect((err) => {
    if (err) {
        console.error('MySQL 연결 오류: ' + err.stack);
        return;
    }
    console.log('MySQL에 연결되었습니다.');
});


let MyClass

const query = 'SELECT * FROM classes';

connection.query(query, (err, results) => {
    if (err) {
        console.error('쿼리 실행 오류: ' + err.stack);
        return;
    }

    // JSON 형태로 결과 데이터를 변환
    MyClass = JSON.stringify(results);

    // 이제 jsonData를 원하는 대로 처리할 수 있습니다.
    console.log('JSON 데이터: ' + jsonData);

    // MySQL 연결 종료
    connection.end();
});




const addClass = () => {
  const classroom = document.querySelector(".classroom");
  const tableTag = classroom.querySelector("table");

  for (let i = 0; i < MyClass.length; i++) {
    const newClass = document.createElement("tr");
    newClass.innerHTML = `
    <td><img src="${MyClass[i].imgsrc}" alt="" /></td>
    <td>${MyClass[i].className}</td><td>${MyClass[i].division}</td>
    <td>${MyClass[i].prof}</td>`;

    newClass.addEventListener("click", () => {
      window.location.href = "course";
    });

    tableTag.appendChild(newClass);
  }

  if(tableTag.childElementCount === 8){
    classroom.style.marginBottom = "57px"
  }
};
