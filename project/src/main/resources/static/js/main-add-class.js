const MyClass = [
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "알고리즘",
    dividion: "1",
    prof: "상상부기",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "자료구조",
    dividion: "A",
    prof: "상상부기2",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "자료구조",
    dividion: "A",
    prof: "상상부기2",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "알고리즘",
    dividion: "1",
    prof: "상상부기",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "자료구조",
    dividion: "A",
    prof: "상상부기2",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "자료구조",
    dividion: "A",
    prof: "상상부기2",
  },
  {
    imgsrc: "/img/sangsangbugi.png",
    className: "자료구조",
    dividion: "A",
    prof: "상상부기2",
  },
];

const addClass = () => {
  const classroom = document.querySelector(".classroom");
  const tableTag = classroom.querySelector("table");

  for (let i = 0; i < MyClass.length; i++) {
    const newClass = document.createElement("tr");
    newClass.innerHTML = `
    <td><img src="${MyClass[i].imgsrc}" alt="" /></td>
    <td>${MyClass[i].className}</td><td>${MyClass[i].dividion}</td>
    <td>${MyClass[i].prof}</td>`;

    newClass.addEventListener("click", () => {
      window.location.href = "new-course-page.html";
    });

    tableTag.appendChild(newClass);
  }

  if(tableTag.childElementCount == 8){
    classroom.style.marginBottom = "32px"
  }
};
