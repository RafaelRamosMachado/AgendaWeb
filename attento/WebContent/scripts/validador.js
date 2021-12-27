/**
 *  Validação de formulário
 * @author Rafael Ramos Machado
 */

function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	let hospital = frmContato.hospital.value
	let cirurgiao = frmContato.cirurgiao.value
	let procedimento = frmContato.procedimento.value
	let cor_tape = frmContato.cor_tape.value
	let data_avaliacao = frmContato.data_avaliacao.value
	let data_cirurgia = frmContato.data_cirurgia.value
	let horario = frmContato.horario.value
	
	
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmContato.nome.focus()
		return false
	} else if (fone === "") {
		alert('Preencha o campo Fone')
		frmContato.fone.focus()
		return false
	} else if (hospital === "") {
		alert('Preencha o campo Hospital')
		frmContato.hospital.focus()
		return false
	} else if (cirurgiao === "") {
		alert('Preencha o campo Cirurgiao')
		frmContato.cirurgiao.focus()
		return false
	} else if (procedimento === "") {
		alert('Preencha o campo Procedimento')
		frmContato.procedimento.focus()
		return false
	} else if (cor_tape === "") {
		alert('Preencha o campo Cor Tape')
		frmContato.cor_tape.focus()
		return false
	} else if (data_avaliacao === "") {
		alert('Preencha o campo Data Avaliação')
		frmContato.data_avaliacao.focus()
		return false
	} else if (data_cirurgia === "") {
		alert('Preencha o campo Data Cirurgia')
		frmContato.data_cirurgia.focus()
		return false
	} else if (horario === "") {
		alert('Preencha o campo Horario Cirurgia')
		frmContato.horario.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}