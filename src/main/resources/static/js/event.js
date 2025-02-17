document.addEventListener("DOMContentLoaded", function() {
    // city filter functionality

    var selectField = document.getElementsByClassName("selectField")
    var selectText = document.getElementById("selectText")
    var options = document.getElementsByClassName("options")
    var list = document.getElementById("list")
    var rotate = document.getElementById("downarrow")
    var placeholder = document.getElementById("EventHeading")
    var cards = document.getElementsByClassName("card")

    for(option of options) {
        option.onclick = function() {
            var selectedCity = this.textContent;
            selectText.innerHTML = selectedCity;
            list.classList.toggle("hidden")
            rotate.classList.toggle("rotates")
            placeholder.innerHTML = `Upcoming Events in ${selectedCity}`;
            
            // Filter cards based on selected city
            for (card of cards) {
                var eventCity = card.getAttribute("data-city");
                if (eventCity === selectedCity) {
                    card.style.display = "block";
                } else {
                    card.style.display = "none";
                }
            }
            console.log(eventCity)
            console.log(selectedCity)
        } 
    }

    for(select of selectField) {
        select.onclick = function() {
            list.classList.toggle("hidden")
            rotate.classList.toggle("rotates")
        }
    }
});



