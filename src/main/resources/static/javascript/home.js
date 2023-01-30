// DOM ELEMENTS
const lessonContainer = document.getElementById('lessonContainer');

// BASE URL
const baseUrl = "http://localhost:8080/api/v1/lessons/"

const headers = {
    'Content-Type': 'application/json'
}

// GET ALL LESSON FUNCTION

// CREATE LESSON CARDS
const createLessonCards = (array) => {
    lessonContainer.innerHTML = ''
    array.forEach(obj => {
        let lessonCard = document.createElement("div")
        lessonCard.innerHTML = `
                <h2>${obj.patron[0].patron_name} with ${obj.instructor[0].instructor_name}</h2>
                <h4>${obj.lesson_time}</h4>
                <h4>${obj.instrument[0].instrument_name}</h4>
                <button class="delete-btn" onclick="handleDelete(${obj.id})">Delete</button>
        `
    })
}

// DELETE LESSON FUNCTION


// CALL GET ALL LESSONS FUNCTION