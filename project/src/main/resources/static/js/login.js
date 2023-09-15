const id = document.getElementById("userId");
const password = document.getElementById("userPw");
const login = document.getElementById("user_login");
let errStack = 0;

function loginHandler() {
  if (id.value == "1971083") {
    if (password.value == "1111") {
      // alert("로그인 성공");
      window.location.href = "new-main-demo.html";
    } else {
      alert("ID 또는 비밀번호 확인");
      errStack++;
    }
  } else {
    alert("ID 또는 비밀번호 확인");
  }
}

login.addEventListener("click", loginHandler);

// Listen for Enter key press event
document.addEventListener("keydown", function (event) {
  if (event.key === "Enter") {
    loginHandler();
  }
});
