const id = document.getElementById("userId");
const password = document.getElementById("userPw");
const login = document.getElementById("user_login");
let errStack = 0;

login.addEventListener("click", () => {
  if (id.value == "1971083") {
    if (password.value == "1111") {
      alert("로그인 되었습니다!");
      window.location.href = "new-main-demo.html";
    } else {
      alert("아이디와 비밀번호를 다시 한 번 확인해주세요!");
      errStack++;
    }
  } else {
    alert("존재하지 않는 계정입니다.");
  }

  if (errStack >= 5) {
    alert("비밀번호를 5회 이상 틀리셨습니다. 비밀번호 찾기를 권장드립니다.");
  }
});
