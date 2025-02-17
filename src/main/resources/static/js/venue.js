var selectField = document.getElementsByClassName("selectField")
var selectText = document.getElementById("selectText")
var options = document.getElementsByClassName("options")
var list = document.getElementById("list")
var rotate = document.getElementById("downarrow")
var placeholder = document.getElementById("EventHeading")
var cards = document.getElementsByClassName("card")

for(select of selectField) {
    select.onclick= function() {
        list.classList.toggle("hidden")
        rotate.classList.toggle("rotates")
    }
}
for(option of options) {
    option.onclick = function() {
        var selectedCity = this.textContent
        selectText.innerHTML = selectedCity
        list.classList.toggle("hidden")
        rotate.classList.toggle("rotates")
        placeholder.innerHTML = `Best Venue in ${selectedCity}`

        for(card of cards) {
            var cityName = card.getAttribute("data-city")
            if(cityName === selectedCity) {
                card.style.display = "block";
            } else {
                card.style.display = "none";
            }
        }
        console.log(cityName)
        console.log(selectedCity)
    }
}