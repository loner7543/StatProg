/**
 * Created by User on 08.10.2016.
 */
var url = "UploadFile";

function abc(){
    alert("dpforgfkmr");
}

function draw(){
    var data = d3.range(1000).map(d3.randomBates(10));//данные

    var formatCount = d3.format(",.0f");

    var svg = d3.select("svg"),
        margin = {top: 10, right: 30, bottom: 30, left: 30},
        width = +svg.attr("width") - margin.left - margin.right,
        height = +svg.attr("height") - margin.top - margin.bottom,
        g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");//gr

    var x = d3.scaleLinear()
        .rangeRound([0, width]);

    var bins = d3.histogram()
        .domain(x.domain())
        .thresholds(x.ticks(20))
    (data);

    var y = d3.scaleLinear()
        .domain([0, d3.max(bins, function(d) { return d.length; })])
        .range([height, 0]);

    var bar = g.selectAll(".bar")
        .data(bins)
        .enter().append("g")
        .attr("class", "bar")
        .attr("transform", function(d) { return "translate(" + x(d.x0) + "," + y(d.length) + ")"; });

    bar.append("rect")
        .attr("x", 1)
        .attr("width", x(bins[0].x1) - x(bins[0].x0) - 1)
        .attr("height", function(d) { return height - y(d.length); });

    bar.append("text")
        .attr("dy", ".75em")
        .attr("y", 6)
        .attr("x", (x(bins[0].x1) - x(bins[0].x0)) / 2)
        .attr("text-anchor", "middle")
        .text(function(d) { return formatCount(d.length); });

    g.append("g")
        .attr("class", "axis axis--x")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));
   /* g.append("g")
        .attr("class","axis axis--y")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisLeft(x));*/
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
