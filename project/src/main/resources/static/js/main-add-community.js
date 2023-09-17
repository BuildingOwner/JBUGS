const RecoContents = [
  {
    title: "자소서 특강",
    imgsrc: "/img/sangsangbugi.png",
    discription: "자기소개서 특강합니다!",
    people: "11",
  },
  {
    title: "직업윤리교육",
    imgsrc: "/img/sangsangbugi.png",
    discription: "직업 의식 고취를 위한 특강",
    people: "35",
  },
  {
    title: "천원의 아침밥 시행안내",
    imgsrc: "/img/sangsangbugi.png",
    discription: "천원의 아침밥 시행안내",
    people: "693",
  },
];

const addCommunity = () => {
  const recoList = document.querySelector(".reco-list");
  recoList.innerHTML = "";

  for (let i = 0; i < RecoContents.length; i++) {
    const newCommunity = document.createElement("div");
    newCommunity.className = "reco-contents";
    newCommunity.innerHTML = `
      <div class="img-center">
        <img src="${RecoContents[i].imgsrc}" alt="reco1Img" />
      </div>
      <h5 class="reco1-title">${RecoContents[i].title}</h5>
      <span class="reco1-discription">${RecoContents[i].discription}</span>
      <span class="reco1-people">${RecoContents[i].people}명 참여중</span>`;

    recoList.appendChild(newCommunity);
  }
};
