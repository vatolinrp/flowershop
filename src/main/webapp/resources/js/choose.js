  function handleDragEnter(e) {
      // this / e.target is the current hover target.
      this.classList.add('over');
  }

  function handleDragLeave(e) {
      this.classList.remove('over'); // this / e.target is previous target element.
  }

  function handleDragEnd(e) {
      [].forEach.call(cols, function(col) {
          col.classList.remove('over');
      });  
      // this/e.target is the source node.    
  }
  var cols = document.querySelectorAll('#columns .column');
  [].forEach.call(cols, function(col) {
      col.addEventListener('dragstart', handleDragStart, false);
      col.addEventListener('dragenter', handleDragEnter, false)
      col.addEventListener('dragover', handleDragOver, false);
      col.addEventListener('dragleave', handleDragLeave, false);
      col.addEventListener('drop', handleDrop, false);
      col.addEventListener('dragend', handleDragEnd, false);
  });
  var cols = document.querySelectorAll('#columns .column');
  [].forEach.call(cols, function(col) {
      col.addEventListener('dragstart', handleDragStart, false);
      col.addEventListener('dragenter', handleDragEnter, false);
      col.addEventListener('dragover', handleDragOver, false);
      col.addEventListener('dragleave', handleDragLeave, false);
  });
  function UnderElement(elem,e) {
    var elemWidth = $(elem).width();
    var elemHeight = $(elem).height();
    var elemPosition = $(elem).offset();
    var elemPosition2 = new Object;
    elemPosition2.top = elemPosition.top + elemHeight;
    elemPosition2.left = elemPosition.left + elemWidth;

    return ((e.pageX > elemPosition.left && e.pageX < elemPosition2.left) && (e.pageY > elemPosition.top && e.pageY < elemPosition2.top))
  }

  function handleDrop(e) {
    if (e.stopPropagation) {
      e.stopPropagation();
    }
    if(!UnderElement(".result", e)) {
      this.innerHTML = e.dataTransfer.getData('text/html');
      resultToInput();
    }
  }
  var dragSrcEl = null;

  function handleDragStart(e) {
      // Target (this) element is the source node.
      dragSrcEl = this;
      e.dataTransfer.effectAllowed = 'move';
      e.dataTransfer.setData('text/html', this.innerHTML);
  }

  function handleDragOver(e) {
      if (e.preventDefault) {
          e.preventDefault(); // Necessary. Allows us to drop.
      }
      e.dataTransfer.dropEffect = 'move'; // See the section on the DataTransfer object.
      return false;
  }


function getPrice() {
  var finalPrice = "";
  $("#bouquet .column").each(function(index, el) {
    var flowerId = $(this).find('div').attr("class");
    if (flowerId !== undefined) {
      var flowerPrice = $("."+flowerId).parents(".flower-wrapper").find('.flower-cost').text();
      finalPrice = Number(flowerPrice) + Number(finalPrice);
    }
  });
  return finalPrice;
}



function resultToInput() {
    var flowers = "";
    $("#bouquet .column").each(function() {
      var flower = $(this).children('div').attr('class');
      if (flower == undefined) {
        flower = "flower19";
      }
      flowers = flowers + "#" + flower;
    });

    $("input[name=placement]").val(flowers);
    $("input[name=cost]").val(getPrice());
}
