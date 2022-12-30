function deletePatient(id){
    swal({
      title: "Desea eliminar este registro?",
      text: "",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        $.ajax({
            url:"/deletePatient/"+id,
            success: ""
        });
        swal("El registro ha sido eliminado!", {
          icon: "success",
        }).then((ok)=>{
            if(ok){
                location.href = "/patientsList"
            }
        });
      }
    });
}

function deleteDoctor(id){
    swal({
      title: "Desea eliminar este registro?",
      text: "",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        $.ajax({
            url:"/deleteDoctor/"+id,
            success: ""
        });
        swal("El registro ha sido eliminado!", {
          icon: "success",
        }).then((ok)=>{
            if(ok){
                location.href = "/doctorsList"
            }
        });
      }
    });
}