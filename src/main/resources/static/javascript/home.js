// DOM ELEMENTS
const lessonContainer = document.getElementById('lessonContainer');

// BASE URL
const baseUrl = "http://localhost:8080/api/v1/lessons/"

const headers = {
    'Content-Type': 'application/json'
}

// GET ALL LESSON FUNCTION
async function getAllLessons() {
    await fetch(`${baseUrl}`, {
        method: "GET",
        headers: headers

    })
        .then(response => response.json())
        .then(data => createLessonCards(data))
        .catch(err => console.error(err))
}

// CREATE LESSON CARDS
const createLessonCards = (array) => {
    lessonContainer.innerHTML = ''
    array.forEach(obj => {
        var lessonId = obj.id
        var lessonTime = obj.lesson_time
        var patronObj = obj.patron
        let patronArray = Object.values(patronObj);
        var patronName = patronArray[1]
        var instructorObj = obj.instructor
        var instructorArray = Object.values(instructorObj);
        var instructorName = instructorArray[1]
        var instrumentObj = obj.instrument
        var instrumentArray = Object.values(instrumentObj);
        var instrumentName = instrumentArray[1]
        console.log(lessonId)
        console.log(lessonTime)
        console.log(patronObj)
        console.log(patronName)
        console.log(instructorObj)
        console.log(instructorName)
        console.log(instrumentObj)
        console.log(instrumentName)
        let lessonCard = document.createElement("div")
        lessonCard.innerHTML = `
            <h2>${patronName} with ${instructorName}</h2>
            <h4>${lessonTime}</h4>
            <h4>${instrumentName}</h4>
            <button class="delete-btn" onclick="handleDelete(${obj.id})">Delete</button>  
        `
        lessonContainer.append(lessonCard)
    })
}

// DELETE LESSON FUNCTION


// CALL GET ALL LESSONS FUNCTION
getAllLessons()