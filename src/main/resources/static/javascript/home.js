// DOM ELEMENTS
const lessonContainer = document.getElementById('lessonContainer');
let patronBtn = document.getElementById('add-patron')
let instructorBtn = document.getElementById('add-instructor')
let instrumentBtn = document.getElementById('add-instrument')
let addLessonBtn = document.getElementById('add-button')

// BASE URL
const baseUrl = "http://localhost:8080/api/v1/lessons/"

const headers = {
    'Content-Type': 'application/json'
}

/*const timestamp = document.getElementById('lesson-time');
const date = new Date(timestamp * 1000);
const dateValues = [  //not sure is this is right or how to use it..
    date.getFullYear(),
    date.getMonth()+1,
    date.getDate(),
    date.getHours(),
    date.getMinutes(),
    date.getSeconds()
];*/

///This function does not make a patron, instructor or instrument it just gets it from the form


//const handleSubmit = async (e) => {
//    e.preventDefault()
//
//    let bodyObj = {
//        patron: document.querySelector("#patron").value,  //need new name as there is already a patron
//        instrument: document.querySelector("#instrument").value,  //need new name
//        instructor: document.querySelector("#instructor").value,  //need new name
//        timestamp: document.querySelector("#lesson-time").value
//    }
//
//    const response = await fetch(`${baseUrl}`, {
//        method: "POST",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//    })
//        .then(response => response.json())
//        .catch(err => console.error(err.message))
//
//    if (response.status == 200) {
//        return getAllLessons();
//    }

const handleSubmit = async (e) => {
    e.preventDefault()

    let patronId = document.querySelector("#patron-select").value;
    let instructorId = document.querySelector("#instructor-select").value;
    let instrumentId = document.querySelector("#instrument-select").value;
    let lessonTime = document.querySelector("#lesson-time").value;

    let bodyObj = {
        patronId: patronId,
        instructorId: instructorId,
        instrumentId: instrumentId,
        lessonTime: lessonTime
    }
    console.log(bodyObj)
    const response = await fetch(`http://localhost:8080/api/v1/lessons`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .then(response => response.json())
        .catch(error => {
            console.error(error);
            return error;
        });
    console.log(response);
    if (response.status === 200) {
        return getAllLessons();
    }
}


const handleSubmit2 = async (e) => {
    e.preventDefault()

    let patronObj = {
        id: null,
        patronName: document.querySelector("#patron").value,
        lessons: null
    }
    await addPatron2(patronObj);
}

async function addPatron2(obj) {
    console.log("add patron test")
    const response = await fetch(`http://localhost:8080/api/v1/patrons`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })

    .catch(err => console.error(err.message))
}

const handleSubmit3 = async (e) => {
    e.preventDefault()

    let instructorObj = {
        id: null,
        instructorName: document.querySelector("#instructor").value,
        lessons: null
    }
    await addInstructor(instructorObj);
}

async function addInstructor(obj) {
    const response = await fetch(`http://localhost:8080/api/v1/instructors`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })

    .catch(err => console.error(err.message))
}

const handleSubmit4 = async (e) => {
    e.preventDefault()

    let instrumentObj = {
        id: null,
        instrumentName: document.querySelector("#instrument").value,
        price: document.querySelector("#price").value,
        quantity: document.querySelector("#quantity").value,
        lessons: null
    }
    await addInstrument(instrumentObj);
}

async function addInstrument(obj) {
    const response = await fetch(`http://localhost:8080/api/v1/instruments`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })

    .catch(err => console.error(err.message))
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

//Get all Patrons
async function getAllPatrons() {
    await fetch(`http://localhost:8080/api/v1/patrons`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
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

// Convert lessonTime to a readable timestamp
        const date = new Date(lessonTime);
        const options = {
            year: 'numeric',
            month: 'long',
            day: 'numeric',
            hour: 'numeric',
            minute: 'numeric',
            hour12: true
        };
        const formattedTime = date.toLocaleString('en-US', options);

        let lessonCard = document.createElement("div")
        lessonCard.innerHTML = `
            <h2>${patronName} with ${instructorName}</h2>
            <h4>${formattedTime}</h4>
            <h4>${instrumentName}</h4>
            <button class="delete-btn" onclick="handleDelete(${obj.id})">Delete</button>  
        `
        lessonContainer.append(lessonCard)
    })
}

// DELETE LESSON FUNCTION


// CALL GET ALL LESSONS FUNCTION
getAllLessons()


addLessonBtn.addEventListener("click", handleSubmit)
patronBtn.addEventListener("click", handleSubmit2)
instructorBtn.addEventListener("click", handleSubmit3)
instrumentBtn.addEventListener("click", handleSubmit4)

async function getPatrons() {
    return await fetch(`http://localhost:8080/api/v1/patrons`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .catch(err => console.error(err))
}

async function populatePatronDropdown() {
    let patronSelect = document.getElementById("patron-select");
    let patrons = await getPatrons();

    patrons.forEach(patron => {
        let option = document.createElement("option");
        option.value = patron.id;
        option.text = patron.patronName;
        patronSelect.appendChild(option);
    });
}
populatePatronDropdown()
async function getInstructors() {
    return await fetch(`http://localhost:8080/api/v1/instructors`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .catch(err => console.error(err))
}

async function populateInstructorDropdown() {
    let instructorSelect = document.getElementById("instructor-select");
    let instructors = await getInstructors();

    instructors.forEach(instructor => {
        let option = document.createElement("option");
        option.value = instructor.id;
        option.text = instructor.instructorName;
        instructorSelect.appendChild(option);
    });
}

populateInstructorDropdown();

async function getInstruments() {
    return await fetch(`http://localhost:8080/api/v1/instruments`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .catch(err => console.error(err))
}

async function populateInstrumentDropdown() {
    let instrumentSelect = document.getElementById("instrument-select");
    let instruments = await getInstruments();

    instruments.forEach(instrument => {
        let option = document.createElement("option");
        option.value = instrument.id;
        option.text = instrument.instrumentName;
        instrumentSelect.appendChild(option);
    });
}

populateInstrumentDropdown();