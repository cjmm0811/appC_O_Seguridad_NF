window.addEventListener('load', function () {

    (function(){

      const url = '/dentists/list';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {

         for(dentist of data){

          let table = document.getElementById("dentistTable");
          let dentistRow =table.insertRow();
          let tr_id = 'tr_' + dentist.id;
          studentRow.id = tr_id;



           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + dentist.id + '\"' +
                                      ' type="button" onclick="deleteBy('+dentist.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';


          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + dentist.id + '\"' +
                                      ' type="button" onclick="findBy('+dentist.id+')" class="btn btn-info btn_id">' +
                                      dentist.id +
                                      '</button>';



         studentRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_first_name\">' + dentist.name.toUpperCase() + '</td>' +
                              '<td class=\"td_last_name\">' + dentist.lastname.toUpperCase() + '</td>' +
                              '<td class=\"td_enrollment\">' + dentist.enrollment.toUpperCase() + '</td>' +
                              '<td>' + deleteButton + '</td>';

        };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/dentistsList.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})