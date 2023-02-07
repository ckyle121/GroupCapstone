// DOM ELEMENTS
const lessonContainer = document.getElementById('lessonContainer');

// BASE URL
const baseUrl = "http://localhost:8080/api/v1/lessons/"

const headers = {
    'Content-Type': 'application/json'
}

const timestamp = document.getElementById('lesson-time');
const date = new Date(timestamp * 1000);
const dateValues = [
    date.getFullYear(),
    date.getMonth()+1,
    date.getDate(),
    date.getHours(),
    date.getMinutes(),
    date.getSeconds()
];

const handleSubmit = async (e) => {
    e.preventDefault()

    addPatron({
        id: null,
        patronName: document.querySelector("#patron").value,
        lessons: null
    })

    addInstructor({
            id: null,
            instructorName: document.querySelector("#instructor").value,
            lessons: null
    })

    addInstrument({
                id: null,
                instrumentName: document.querySelector("#instrument").value,
                price: null,
                quantity: null,
                lessons: null
    })


    let bodyObj = {
        patron: document.querySelector("#patron").value,
        instrument: document.querySelector("#instrument").value,
        instructor: document.querySelector("#instructor").value,
        timestamp: document.querySelector("#lesson-time").value
    }

    const response = await fetch(`${baseUrl}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .then(response => response.json())
        .catch(err => console.error(err.message))

    if (response.status == 200) {
        return getAllLessons();
    }


const addPatron = async (e) => {
    e.preventDefault()

    const response = await fetch(`http://localhost:8080/api/v1/patrons/addPatron`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })

    .catch(err => console.error(err.message))
}

async function addInstructor(obj) {
    const response = await fetch(`http://localhost:8080/api/v1/instructors`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })

    .catch(err => console.error(err.message))
}

async function addInstrument(obj) {
    const response = await fetch(`http://localhost:8080/api/v1/instruments`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })

    .catch(err => console.error(err.message))
}
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
        var lessonTime = obj.lesson_time //need to be converted to a prettier format (readable timestamp)
        var patronObj = obj.patron
        let patronArray = Object.values(patronObj);
        var patronName = patronArray[1]
        var instructorObj = obj.instructor
        var instructorArray = Object.values(instructorObj);
        var instructorName = instructorArray[1]
        var instrumentObj = obj.instrument
        var instrumentArray = Object.values(instrumentObj);
        var instrumentName = instrumentArray[1]

//        console.log(lessonId)
//        console.log(lessonTime)
//        console.log(patronObj)
//        console.log(patronName)
//        console.log(instructorObj)
//        console.log(instructorName)
//        console.log(instrumentObj)
//        console.log(instrumentName)

        let lessonCard = document.createElement("div")
        lessonCard.innerHTML = `
            <h2>${patronName} with ${instructorName}</h2>
            <h4>${lessonTime}</h4> //want to make this a pretty timestamp
            <h4>${instrumentName}</h4>
            <button class="delete-btn" onclick="handleDelete(${obj.id})">Delete</button>  
        `
        lessonContainer.append(lessonCard)
    })
}

// DELETE LESSON FUNCTION


// CALL GET ALL LESSONS FUNCTION
getAllLessons()

document.querySelector("#add-button").addEventListener("click", handleSubmit)