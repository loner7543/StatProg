/**
 * Created by User on 08.10.2016.
 */
var url = "UploadFile";

function abc(){
    alert("dpforgfkmr");
}

function draw(){
    var data = [
            {
              value:25,
                label:'Java',
                color:'#6AE128'
            }
    ];
    var context = document.getElementById('clients').getContext('2d');
    var options = 0;
    var chart = new Chart((context),{
            type:'pie',
        data:data,
        options:options
        });
}

function UploadFile(){
    var files = document.getElementById("my_file").files;//массив файлов тут
    var list = $("#filename_list");
   /* while(list.hasChildNodes()){
        list.removeChild(li);
    }*/
    for(var i = 0;i<files.length;i++){
        var li = document.createElement('li');
        li.innerHTML=files[i].name;
        list.append(li);
    }
var  xhr = new XMLHttpRequest();
    xhr.open("POST",url,true);
    xhr.send(files);
   /* var xhr = new XMLHttpRequest();
    xhr.upload.onprogress = function(event){
        //log(event.loaded)
    }
    xhr.open("POST",url,true);
    xhr.send(file)*/
}
