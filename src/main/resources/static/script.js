function addStudent(){

const name = document.getElementById("name").value;
const email = document.getElementById("email").value;
const branch = document.getElementById("branch").value;

fetch("http://localhost:8080/students",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({
name:name,
email:email,
branch:branch
})
})
.then(res=>res.json())
.then(data=>{
alert("Student Added Successfully");
});
}

function loadStudents(){

fetch("http://localhost:8080/students")
.then(res=>res.json())
.then(data=>{

const list=document.getElementById("studentList");
list.innerHTML="";

data.forEach(student=>{

const li=document.createElement("li");
li.innerText=student.name+" - "+student.branch;

list.appendChild(li);

});

});

}