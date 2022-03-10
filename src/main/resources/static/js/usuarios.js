// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();

  $('#usuarios').DataTable();
  actualizarEmailUsuario();

});

function actualizarEmailUsuario() {
  document.getElementById('txtEmailUsuario').outerHTML = localStorage.email;
}

async function cargarUsuarios() {

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeaders()
  });

  const usuarios = await request.json();
  console.log(usuarios);

  let listaUsuarios = '';
  
  for (let usuario of usuarios) {
    let botonEliminar = '<a href="#" onclick="eliminarUsuario('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let usuarioHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email 
                    +'</td><td>'+ usuario.telefono 
                    +'</td><td>'+ botonEliminar +'</td></tr> ';

    listaUsuarios += usuarioHtml;

  }

  document.querySelector('#usuarios tbody').outerHTML = listaUsuarios;
}

function getHeaders() {
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  }
}

async function eliminarUsuario(id) {

  if (confirm('¿Realmente desea eliminar el usuario?', true)) {

    const request = await fetch('api/usuarios/' + id, {
      method: 'DELETE',
      headers: getHeaders()
    });

    location.reload(); //Actualizar pagina
  }

}
