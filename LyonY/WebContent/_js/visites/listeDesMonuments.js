/**
 * 
 */
$(document).ready(function() {
	$('#listeDesMonuments').DataTable({
		   "language": {
	            "lengthMenu": "Montrer _MENU_ items par page",
	            "zeroRecords": "Aucun résultat",
	            "info": "Page _PAGE_ sur _PAGES_",
	            "infoEmpty": "Aucun résultat",
	            "infoFiltered": "(filtered from _MAX_ total records)",
	            "search" : "Rechercher",
	            "paginate": {        
	            			"next":       "Suivant",        
	            			"previous":   "Précédent"
	            }
	            
	        },
	});
});