document.querySelector(".goQuiz").addEventListener("click", () => {
  window.location.href = `/quiz?classesId=${searchParam('classesId')}&week=${searchParam('week')}`;
  searchParam('classesId');
})

function searchParam(key) {
  return new URLSearchParams(location.search).get(key);
}