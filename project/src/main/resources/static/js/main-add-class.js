const MyClass = [
  {
    className: '알고리즘',
    dividion: '1',
    prof: '상상부기'
  },
  {
    className: '자료구조',
    dividion: 'A',
    prof: '상상부기2'
  }
]

const addClass = () => {
  const classroom = document.querySelector('.classroom');
  const tableTag = classroom.querySelector('table');

  for(let i=0; i<MyClass.length; i++){
    let newClass = document.createElement('tr');
    newClass.innerHTML = `<td><img src="../../static/img/sangsangbugi.png" alt="" /></td><td>${MyClass[i].className}</td><td>${MyClass[i].dividion}</td><td>${MyClass[i].prof}</td>`;

    tableTag.appendChild(newClass);
  }
}