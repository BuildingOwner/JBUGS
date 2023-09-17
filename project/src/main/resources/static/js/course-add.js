const MyContent = [
  {
    videos: [
      {
        videosrc: "/video/video1.mp4",
        videoname: "1주차 강의 1",
      },
      {
        videosrc: "비디오경로",
        videoname: "1주차 강의 2",
      },
      {
        videosrc: "비디오경로",
        videoname: "1주차 강의 3",
      },
    ],
    files: [
      {
        filename: "강의파일1",
        filesrc: "/img/sangsangbugi.png",
      },
      {
        filename: "강의파일2",
        filesrc: "/img/sangsangbugi.png",
      },
    ],
  },
  {
    videos: [
      {
        videosrc: "비디오경로",
        videoname: "2주차 강의 1",
      },
      {
        videosrc: "비디오경로",
        videoname: "2주차 강의 2",
      },
      {
        videosrc: "비디오경로",
        videoname: "2주차 강의 2",
      },
    ],
    files: [
      {
        filename: "파일제목",
        filesrc: "/img/sangsangbugi.png",
      },
      {
        filename: "파일제목",
        filesrc: "/img/sangsangbugi.png",
      },
    ],
  },
  {
    videos: [
      {
        videosrc: "/video/video1.mp4",
        videoname: "1주차 강의 1",
      },
      {
        videosrc: "비디오경로",
        videoname: "1주차 강의 2",
      },
      {
        videosrc: "비디오경로",
        videoname: "1주차 강의 3",
      },
    ],
    files: [
      {
        filename: "강의파일1",
        filesrc: "/img/sangsangbugi.png",
      },
      {
        filename: "강의파일2",
        filesrc: "/img/sangsangbugi.png",
      },
    ],
  },
  {
    videos: [
      {
        videosrc: "/video/video1.mp4",
        videoname: "1주차 강의 1",
      },
      {
        videosrc: "비디오경로",
        videoname: "1주차 강의 2",
      },
      {
        videosrc: "비디오경로",
        videoname: "1주차 강의 3",
      },
    ],
    files: [
      {
        filename: "강의파일1",
        filesrc: "/img/sangsangbugi.png",
      },
      {
        filename: "강의파일2",
        filesrc: "/img/sangsangbugi.png",
      },
    ],
  },
];

const addContent = () => {
  for (let i = 0; i < 16; i++) {
    const panel = document.querySelector(`.panel_${i + 1}`);
    for (let j = 0; j < MyContent[i].videos.length; j++) {
      const newVideo = document.createElement("div");
      newVideo.classList.add("content-progress");

      // Create video element
      const videoDiv = document.createElement("div");
      videoDiv.classList.add("videoInfo")
      videoDiv.innerHTML=`
      <span>${MyContent[i].videos[j].videoname}</span>
      `;
      const videoElement = document.createElement("video");
      videoElement.classList.add("class-content");
      videoElement.controls = true;
      videoElement.width = 300;
      videoElement.innerHTML = `
        <source src="${MyContent[i].videos[j].videosrc}" />   
      `;
      videoDiv.appendChild(videoElement);
      // Create progress bar
      const progressBar = document.createElement("div");
      progressBar.classList.add("bar-holder");
      const progressInner = document.createElement("div");
      progressInner.classList.add("bar");
      progressInner.textContent = "00%";
      progressBar.appendChild(progressInner);

      // Append video and progress bar to the newVideo container

      newVideo.appendChild(videoDiv);
      newVideo.appendChild(progressBar);
      panel.appendChild(newVideo);

      // Add a timeupdate event listener to update the progress bar
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
      panel.appendChild(newFile);
    }
  }
}

// 호출하여 콘텐츠 추가
addContent();
