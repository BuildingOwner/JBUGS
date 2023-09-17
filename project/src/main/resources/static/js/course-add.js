const MyContent = [
	{
		videos : [{
			videosrc : "비디오경로",
			vidioname : "비디오제목",
		},
			{
				videosrc : "비디오경로",
				vidioname : "비디오제목",
			},
			{
				videosrc : "비디오경로",
				vidioname : "비디오제목",
			}
		],
		files : [{
			filename : "파일제목",
			filesrc : "/img/sangsangbugi.png",
		},
			{
				filename : "파일제목",
				filesrc : "/img/sangsangbugi.png",
			}]
	}];

const addContent = () => {
	for(let i=0;i<16;i++){
		const panel = document.querySelector(`.panel_${i+1}`);
		for(let j=0; j<MyContent[i].videos.length ; j++){
			const newVideo = document.createElement("div");
			newVideo.classList.add("content-progress");
			newVideo.innerHTML = `
    		 <video class="class-content" controls width="300">
          <source src="${MyContent[i].videos[j].videosrc}" />
          <span>${MyContent[i].videos[j].videoname}</span>
          <div class="bar-holder">
              <div class="bar">40%</div>
           </div>
         </video>
    		`;
			panel.appendChild(newVideo);
		}
		for(let k=0; k<MyContent[i].files.length ; k++){
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




