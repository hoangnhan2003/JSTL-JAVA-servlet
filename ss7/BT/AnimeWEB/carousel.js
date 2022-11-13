// const productContainers = [...document.querySelectorAll('.movie-carousel')];
// const nxtBtn = [...document.querySelectorAll('.nxt-btn')];
// const preBtn = [...document.querySelectorAll('.pre-btn')];
const productContainers = document.querySelector('.movie-carousel')
const nxtBtn = document.querySelector('.nxt-btn');
const preBtn = document.querySelector('.pre-btn');
// let containerDimensions = productContainers.getBoundingClientRect();
// let containerWidth = containerDimensions.width;
nxtBtn.onclick = function(){
    productContainers.scrollLeft+= 400;
}
preBtn.onclick = function(){
    productContainers.scrollLeft -= 400;
}
// productContainers.forEach((item, i) => {
//     let containerDimensions = item.getBoundingClientRect();
//     let containerWidth = containerDimensions.width;

//     nxtBtn[i].addEventListener('click', () => {
//         item.scrollLeft += containerWidth;
//     })

//     preBtn[i].addEventListener('click', () => {
//         item.scrollLeft -= containerWidth;
//     })
// })