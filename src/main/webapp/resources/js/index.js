const header = document.querySelector('#header')
const headerHight = header.offsetHeight

function changeHeaderWhenScroll() {
  if (window.scrollY >= headerHight) {
    // scroll é maior que a altura do header
    header.classList.add('scroll')
    console.log('entrou add')
  } else {
    // menor que a altura do header
    console.log('entrou remove')
    header.classList.remove('scroll')
  }
}

window.addEventListener('scroll', function () {
  changeHeaderWhenScroll()
 
})