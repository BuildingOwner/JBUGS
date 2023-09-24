const MyContent = [
  {
    videos: [
      {
        videosrc: "/file/3/1/video/video1.mp4",
        videoname: "1주차 강의 1",
      },
    ],
    files: [
      {
        filename: "asd",
        filesrc: "/file/3/1/file/asd.pdf",
      },
    ],
  },
];

// let addContent;
apiUrl = '/api/v2/homeworks';

fetch(apiUrl)
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    // MyContent = data
    addContent();
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });

const addContent = () => {
  for (let i = 0; i < MyContent.length; i++) {
    const panel = document.querySelector(`.panel_${i + 1}`);
    for (let j = 0; j < MyContent[i].videos.length; j++) {
      const newVideo = document.createElement("div");
      newVideo.classList.add("content-progress");

      const videoDiv = document.createElement("div");
      videoDiv.classList.add("videoInfo");

      const videoElement = document.createElement("video");
      videoElement.classList.add("class-content");
      videoElement.controls = true;
      videoElement.width = 600;
      videoElement.innerHTML = `
        <source src="${MyContent[i].videos[j].videosrc}" />   
      `;
      // 이전에 저장된 재생 시간 가져오기
      const savedTime = localStorage.getItem(`videoTime-${i}-${j}`);

      // 재생 시간 설정
      if (savedTime) {
        videoElement.currentTime = parseFloat(savedTime);
      }

      // 동영상 재생 시간 업데이트 및 저장
      videoElement.addEventListener("timeupdate", function () {
        const currentTime = videoElement.currentTime;
        localStorage.setItem(`videoTime-${i}-${j}`, currentTime);
      });

      // 페이지 unload 시에 재생 시간 저장
      window.addEventListener("beforeunload", function () {
        const currentTime = videoElement.currentTime;
        localStorage.setItem(`videoTime-${i}-${j}`, currentTime);
      });

      // Span 태그 추가 (videoInfo 내부)
      const spanElement = document.createElement("span");
      spanElement.textContent = MyContent[i].videos[j].videoname;

      // Progress Bar
      const progressBar = document.createElement("div");
      progressBar.classList.add("bar-holder");
      const progressInner = document.createElement("div");
      progressInner.classList.add("bar");
      progressInner.textContent = "00%";
      progressBar.appendChild(progressInner);

      // Wrapping video title and progress bar in a div
      const videoTitleAndProgressBar = document.createElement("div");
      videoTitleAndProgressBar.classList.add("TitleAndProgressBar");
      videoTitleAndProgressBar.appendChild(spanElement);
      videoTitleAndProgressBar.appendChild(progressBar);

      videoDiv.appendChild(videoElement);
      videoDiv.appendChild(videoTitleAndProgressBar);

      newVideo.appendChild(videoDiv);
      panel.appendChild(newVideo);

      videoElement.addEventListener("timeupdate", () => {
        const currentTime = videoElement.currentTime;
        const duration = videoElement.duration;
        const progress = (currentTime / duration) * 100;
        progressInner.style.width = `${progress}%`;
        progressInner.textContent = `${progress.toFixed(0)}%`;
      });
    }

    for (let k = 0; k < MyContent[i].files.length; k++) {
      const newFile = document.createElement("div");
      newFile.innerHTML = `
        <div class="content-file"><i class="bi bi-file-earmark-arrow-down-fill"></i> ${MyContent[i].files[k].filename}</div>
      `;
      newFile.addEventListener("click", () => {
        window.location.href = `${MyContent[i].files[k].filesrc}`;
      });
      //
      panel.appendChild(newFile);
    }
  }
}
