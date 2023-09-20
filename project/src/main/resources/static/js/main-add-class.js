const MyClass = [
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "네트워크프로그래밍",
    division: "B",
    prof: "신성",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "설계패턴",
    division: "C",
    prof: "한기준",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "데이터통신",
    division: "D",
    prof: "김동욱",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "모바일&스마트시스템",
    division: "B",
    prof: "이재문",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "고급모바일프로그래밍",
    division: "A",
    prof: "허준영",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "웹프레임워크",
    division: "B",
    prof: "박승현",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "시스템프로그래밍",
    division: "D",
    prof: "안영아",
  },
];

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
