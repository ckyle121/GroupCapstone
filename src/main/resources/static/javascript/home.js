// DOM ELEMENTS
const lessonContainer = document.getElementById('lessonContainer');
let patronBtn = document.getElementById('add-patron')
let instructorBtn = document.getElementById('add-instructor')
let instrumentBtn = document.getElementById('add-instrument')

// BASE URL
const baseUrl = "http://localhost:8080/api/v1/lessons/"

const headers = {
    'Content-Type': 'application/json'
}

const timestamp = document.getElementById('lesson-time');
const date = new Date(timestamp * 1000);
const dateValues = [  //not sure is this is right or how to use it..
    date.getFullYear(),
    date.getMonth()+1,
    date.getDate(),
    date.getHours(),
    date.getMinutes(),
    date.getSeconds()
];

//This was removed and is no longer relevant:

///This function does not make a patron, instructor or instrument it just gets it from the form

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        patron: document.querySelector("#patron-dropdown").value,  //need new name as there is already a patron
        instrument: document.querySelector("#instrument-dropdown").value,  //need new name
        instructor: document.querySelector("#instructor-dropdown").value,  //need new name
        timestamp: document.querySelector("#lesson-time").value
    }

    //when you first load the page, you need a fetch to fetch the instructor, patron, instrument.


    const createLesson = (array) => {
    console.log("logging array in CreateDrugFieldData", array)
    patientPrescriptionsDisplay.innerHTML = ''
    array.forEach(obj => {
    let drugFields = document.createElement("div")
    drugFields.innerHTML = `
    <div class="accordion d-grid gap-3" id="accordionExample">
    	<div class="accordion-item">
    		<h2 class="accordion-header" id="headingOne">
    			<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
    			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-capsule-pill" viewBox="0 0 16 16">
                  <path d="M11.02 5.364a3 3 0 0 0-4.242-4.243L1.121 6.778a3 3 0 1 0 4.243 4.243l5.657-5.657Zm-6.413-.657 2.878-2.879a2 2 0 1 1 2.829 2.829L7.435 7.536 4.607 4.707ZM12 8a4 4 0 1 1 0 8 4 4 0 0 1 0-8Zm-.5 1.042a3 3 0 0 0 0 5.917V9.042Zm1 5.917a3 3 0 0 0 0-5.917v5.917Z"/>
                </svg>&ensp;Adverse Reactions
            </button>
    		</h2>
    		<div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
    			<div class="accordion-body">
    				<p>${obj.adverse_reactions}</p>
    			</div>
    		</div>
    	</div>
    	<div class="accordion-item">
    		<h2 class="accordion-header" id="headingTwo">
    			<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-capsule-pill" viewBox="0 0 16 16">
                  <path d="M11.02 5.364a3 3 0 0 0-4.242-4.243L1.121 6.778a3 3 0 1 0 4.243 4.243l5.657-5.657Zm-6.413-.657 2.878-2.879a2 2 0 1 1 2.829 2.829L7.435 7.536 4.607 4.707ZM12 8a4 4 0 1 1 0 8 4 4 0 0 1 0-8Zm-.5 1.042a3 3 0 0 0 0 5.917V9.042Zm1 5.917a3 3 0 0 0 0-5.917v5.917Z"/>
                </svg>&ensp;Contraindications
            </button>
    		</h2>
    		<div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
    			<div class="accordion-body">
    				<p>${obj.contraindications}</p>
    			</div>
    		</div>
    	</div>
    	<div class="accordion-item">
    		<h2 class="accordion-header" id="headingThree">
    			<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-capsule-pill" viewBox="0 0 16 16">
                  <path d="M11.02 5.364a3 3 0 0 0-4.242-4.243L1.121 6.778a3 3 0 1 0 4.243 4.243l5.657-5.657Zm-6.413-.657 2.878-2.879a2 2 0 1 1 2.829 2.829L7.435 7.536 4.607 4.707ZM12 8a4 4 0 1 1 0 8 4 4 0 0 1 0-8Zm-.5 1.042a3 3 0 0 0 0 5.917V9.042Zm1 5.917a3 3 0 0 0 0-5.917v5.917Z"/>
                </svg>&ensp;Drug Interactions
        </button>
    		</h2>
    		<div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
    			<div class="accordion-body">
    				<p>${obj.drug_interactions}</p>
    			</div>
    		</div>
    	</div>


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

// CREATE LESSON CARDS
const createLessonCards = (array) => {
    lessonContainer.innerHTML = ''
    array.forEach(obj => {

        let lessonId = obj.id
        let lessonTime = obj.lesson_time //need to be converted to a prettier format (readable timestamp)
        let patronObj = obj.patron
        let patronArray = Object.values(patronObj);
<<<<<<< .merge_file_AdZIBV
        let patronName = patronArray[1]
        let instructorObj = obj.instructor
        let instructorArray = Object.values(instructorObj);
        let instructorName = instructorArray[1]
        let instrumentObj = obj.instrument
        let instrumentArray = Object.values(instrumentObj);
        let instrumentName = instrumentArray[1]

//        console.log(lessonId)
//        console.log(lessonTime)
//        console.log(patronObj)
//        console.log(patronName)
//        console.log(instructorObj)
//        console.log(instructorName)
//        console.log(instrumentObj)
//        console.log(instrumentName)


// DELETE LESSON FUNCTION

=======
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
>>>>>>> .merge_file_YtAPhD
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

<<<<<<< .merge_file_AdZIBV
=======
// DELETE LESSON FUNCTION
async function handleDelete(lessonId){
    await fetch(baseUrl + lessonId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))
>>>>>>> .merge_file_YtAPhD

    return getAllLessons();
}

// CALL GET ALL LESSONS FUNCTION
getAllLessons()

//document.querySelector("#add-button").addEventListener("click", handleSubmit)
patronBtn.addEventListener("click", handleSubmit2)
instructorBtn.addEventListener("click", handleSubmit3)
instrumentBtn.addEventListener("click", handleSubmit4)