/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarCampos() {
    if (document.getElementById("produto__nome").value == '') {
        alert('informe o nome do Produto');
        return false;
    } else
    if (document.getElementById("produto__categoria").value == '') {
        alert('informe a categoria');
        return false;
    } else
    if (document.getElementById("produto__idioma").value == '') {
        alert('informe o idioma');
        return false;
    } else
    if (document.getElementById("editora_produtora").value == '') {
        alert('informe a editora');
        return false;
    }
}



