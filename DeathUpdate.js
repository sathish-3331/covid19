    var patientAaadhrNumber;
	var patientName;
	var gender;
	var age;
	var Mobilenumber;
	var zoneareaname;
	var stateName;
	var postcode;
	var otherHealthIssue;
function deathFunction() {

	var dataView;
	var grid;
	var columnFilters = {};
	var data = document.getElementById("death").value;
	console.log(data);
	var data1 = JSON.parse(data);
	var nextId = 1;
	data1.forEach(function(item) {
		// Generate a unique id using the nextId value
		var itemId = "item_" + nextId;
		// Set the id property of the item object
		item.id = itemId;
		// Increment the nextId value
		nextId++;
	});

	/* set unique it to array */
	var resendMessage = function(row, cell, value, columnDef, dataContext) {
		 patientAaadhrNumber=dataContext.patientAaadharNumber;
		 patientName=dataContext.Deathusername;
		  gender=dataContext.Gender;
		 age=dataContext.age;
		 Mobilenumber=dataContext.mobilenumber;
		 zoneareaname=dataContext.zoneareaname;
		 stateName=dataContext.stateName;
		 postcode=dataContext.postcode;
		 otherHealthIssue=dataContext.otherHealthIssue;
		//return '<button id="sendmessage" onclick="onclickpop()" type="submit">Update Death</button>'
		 return '<button type="submit" onclick="DSalert()" id="popupLog">UPDATE</button>'
}

   var reUpdate = function(row, cell, value, columnDef, dataContext) {
	    patientAaadhrNumber=dataContext.patientAaadharNumber;
		return '<button type="submit" onclick="JSalert()" id="popupLog">UPDATE</button>'

		//return '<button id="sendmessage" onclick="onclickpopUpdate('+ patientAaadhrNumber + ')">ReUpdate Patient</button>'
	}
		//	return '<button id="sendmessage" onclick="updateFunction('+ updatepatientAaadhrNumber + ')">ReUpdate Patient</button>'

	// Use the updated items array list with unique ids
	console.log(data1);
	/* unique id end */
	var options = {
        enableCellNavigation: true,
        showHeaderRow: true,
        headerRowHeight: 30,
        explicitInitialization: true,
        headerHeight: 30
    };
	var columnFilters = {};

	var columns = [{
		id: "Deathappointregid",
		name: "Patient Code",
		field: "Deathappointregid",
		sortable: true,
		width:200,
	},
	{
		id: "patientAaadharNumber",
		name: "Patient AadharNumber",
		field: "patientAaadharNumber",
		sortable: true,
		width: 260,
	},
	 {
		id: "Deathusername",
		name: "Patient Name",
		field: "Deathusername",
		sortable: true,
		width: 180,
	}, {
		id: "age",
		name: "Patient Age",
		field: "age",
		sortable: true,
		width: 160,
	},
	{
		id: "mobilenumber",
		name: "Mobile Number",
		field: "mobilenumber",
		sortable: true,
		width: 200,
},
{
	    id: "Gender",
		name: "Gender",
		field: "Gender",
		sortable: true,
		width: 100,
	},
	{
		id: "zoneareaname",
		name: "Zone Name",
		field: "zoneareaname",
		sortable: true,
		width: 200,
},
{
		id: "stateName",
		name: "State Name",
		field: "stateName",
		sortable: true,
		width: 200,
},
{
		id: "postcode",
		name: "Pincode",
		field: "postcode",
		sortable: true,
		width: 200,
},
{
		id: "feverOrChills",
		name: "Fever Chills",
		field: "feverOrChills",
		sortable: true,
		width: 200,
},
{
		id: "Cough",
		name: "Cough",
		field: "Cough",
		sortable: true,
		width: 200,
},
{
		id: "Thoratpain",
		name: "Thorat Pain",
		field: "Thoratpain",
		sortable: true,
		width: 200,
},
{
		id: "fatigue",
		name: "Fatigue",
		field: "fatigue",
		sortable: true,
		width: 200,
},
{
		id: "muscleOrBodyAches",
		name: "Muscle Pain",
		field: "muscleOrBodyAches",
		sortable: true,
		width: 200,
},
{
		id: "otherHealthIssue",
		name: "Other HealthIssue",
		field: "otherHealthIssue",
		sortable: true,
		width: 250,
		},
{
		id: "deathUpdate",
		name: "Update Death",
		field: "deathUpdate",
		sortable: true,
		width: 200,
		formatter:resendMessage,
		},
  {
		id: "moveToUpdate",
		name: "Update Patient",
		field: "moveToUpdate",
		sortable: true,
		width: 200,
		formatter:reUpdate
		}
];

	var options = {
		editable: true,
		enableAddRow:false,
		enableCellNavigation: true,
		asyncEditorLoading: true,
		forceFitColumns: false,
		showHeaderRow: true,
		headerRowHeight: 30,
		headerRowWidth:60,
		explicitInitialization: true,
		topPanelHeight: 75,
		rowHeight:80,
		suppressCssChangesOnHiddenInit: true
	};


	var sortcol = "title";
	var sortdir = 1;
	var percentCompleteThreshold = 0;
	var searchString = "";

	function requiredFieldValidator(value) {
		if (value == null || value == undefined || !value.length) {
			return { valid: false, msg: "This is a required field" };
		}
		else {
			return { valid: true, msg: null };
		}
	}

	function myFilter(item, args) {
		if (item["percentComplete"] < args.percentCompleteThreshold) {
			return false;
		}

		if (args.searchString != "" && item["title"].indexOf(args.searchString) == -1) {
			return false;
		}

		return true;
	}

	function percentCompleteSort(a, b) {
		return a["percentComplete"] - b["percentComplete"];
	}

	function comparer(a, b) {
		var x = a[sortcol], y = b[sortcol];
		return (x == y ? 0 : (x > y ? 1 : -1));
	}

	function toggleFilterRow() {
		grid.setTopPanelVisibility(!grid.getOptions().showTopPanel);
	}


	$(".grid-header .ui-icon")
		.addClass("ui-state-default ui-corner-all")
		.mouseover(function(e) {
			$(e.target).addClass("ui-state-hover")
		})
		.mouseout(function(e) {
			$(e.target).removeClass("ui-state-hover")
		});

	$(function() {
		/* filter start */
		function filter(item) {
			for (var columnId in columnFilters) {
				if (columnId !== undefined && columnFilters[columnId] !== "") {
					var column = grid.getColumns()[grid.getColumnIndex(columnId)];

					if (item[column.field] !== undefined) {
						var filterResult = typeof item[column.field].indexOf === 'function'
							? (item[column.field].indexOf(columnFilters[columnId]) === -1)
							: (item[column.field] != columnFilters[columnId]);

						if (filterResult) {
							return false;
						}
					}
				}
			}
			return true;
		}
		/* filter end */


		//		dataView = new Slick.Data.DataView({ inlineFilters: true });
		dataView = new Slick.Data.DataView();
		grid = new Slick.Grid("#deathGridUpdate", dataView, columns, options);
		grid.setSelectionModel(new Slick.RowSelectionModel());

		var pager = new Slick.Controls.Pager(dataView, grid, $("#pager"));
		var columnpicker = new Slick.Controls.ColumnPicker(columns, grid, options);

		// header row start
		dataView.onRowCountChanged.subscribe(function(e, args) {
			grid.updateRowCount();
			grid.render();
		});

		dataView.onRowsChanged.subscribe(function(e, args) {
			grid.invalidateRows(args.rows);
			grid.render();
		});
		
		$(grid.getHeaderRow()).delegate(":input", "change keyup",
			function(e) {
				var columnId = $(this).data("columnId");
				if (columnId != null) {
					columnFilters[columnId] = $.trim($(this).val());
					dataView.refresh();
				}
			});

		grid.onHeaderRowCellRendered.subscribe(function(e, args) {
			$(args.node).empty();
			$("<input type='text'>").data("columnId", args.column.id).val(
				columnFilters[args.column.id]).appendTo(args.node);

		});
		// header row end


		// move the filter panel defined in a hidden div into grid top panel
		$("#inlineFilterPanel")
			.appendTo(grid.getTopPanel())
			.show();

		grid.onCellChange.subscribe(function(e, args) {
			dataView.updateItem(args.item.id, args.item);
		});

		grid.onAddNewRow.subscribe(function(e, args) {
			var item = { "num": data.length, "id": "new_" + (Math.round(Math.random() * 10000)), "title": "New task", "duration": "1 day", "percentComplete": 0, "start": "01/01/2009", "finish": "01/01/2009", "effortDriven": false };
			$.extend(item, args.item);
			dataView.addItem(item);
		});

		grid.onKeyDown.subscribe(function(e) {
			// select all rows on ctrl-a
			if (e.which != 65 || !e.ctrlKey) {
				return false;
			}

			var rows = [];
			for (var i = 0; i < dataView.getLength(); i++) {
				rows.push(i);
			}

			grid.setSelectedRows(rows);
			e.preventDefault();
		});

		grid.onSort.subscribe(function(e, args) {
			sortdir = args.sortAsc ? 1 : -1;
			sortcol = args.sortCol.field;

			if ($.browser.msie && $.browser.version <= 8) {
				// using temporary Object.prototype.toString override
				// more limited and does lexicographic sort only by default, but can be much faster

				var percentCompleteValueFn = function() {
					var val = this["percentComplete"];
					if (val < 10) {
						return "00" + val;
					} else if (val < 100) {
						return "0" + val;
					} else {
						return val;
					}
				};

				// use numeric sort of % and lexicographic for everything else
				dataView.fastSort((sortcol == "percentComplete") ? percentCompleteValueFn : sortcol, args.sortAsc);
			} else {
				// using native sort with comparer
				// preferred method but can be very slow in IE with huge datasets
				dataView.sort(comparer, args.sortAsc);
			}
		});

		// wire up model events to drive the grid
		dataView.onRowCountChanged.subscribe(function(e, args) {
			grid.updateRowCount();
			grid.render();
		});

		dataView.onRowsChanged.subscribe(function(e, args) {
			grid.invalidateRows(args.rows);
			grid.render();
		});

		dataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
			var isLastPage = pagingInfo.pageNum == pagingInfo.totalPages - 1;
			var enableAddRow = isLastPage || pagingInfo.pageSize == 0;
			var options = grid.getOptions();

			if (options.enableAddRow != enableAddRow) {
				grid.setOptions({ enableAddRow: enableAddRow });
			}
		});


		var h_runfilters = null;
		function updateFilter() {
			dataView.setFilterArgs({
				percentCompleteThreshold: percentCompleteThreshold,
				searchString: searchString
			});
			dataView.refresh();
		}

		$("#btnSelectRows").click(function() {
			if (!Slick.GlobalEditorLock.commitCurrentEdit()) {
				return;
			}

			var rows = [];
			for (var i = 0; i < 10 && i < dataView.getLength(); i++) {
				rows.push(i);
			}

			grid.setSelectedRows(rows);
		});


		// initialize the model after all the events have been hooked up
		grid.init();
		dataView.beginUpdate();
		dataView.setItems(data1);
		/*
		dataView.setFilterArgs({
			percentCompleteThreshold: percentCompleteThreshold,
			searchString: searchString
		});
		*/
		dataView.setFilter(filter);
		dataView.endUpdate();

		// if you don't want the items that are not visible (due to being filtered out
		// or being on a different page) to stay selected, pass 'false' to the second arg
		dataView.syncGridSelection(grid, true);

		//$("#gridContainer").resizable();
	})
	
}
function JSalert(){
swal({
 title: "Are you sure?",
 text: "This  Patient Will Be Move to,Update!",
 icon: "warning",
 buttons: true,
 dangerMode: true,
})
.then((willDelete) => {
 if (willDelete) {
   swal({
   title:"Okey Fine All The Details Fetch Now!",
   icon: "success",
   
   })
   .then((willRedirect) => {
       if (willRedirect) {
        window.location.href = "/reUpdateAppointment?updatePatientAaddharNo=" + patientAaadhrNumber;
        alert("SucessFully Added in UpdatedList")
       } else {
         swal("Ok this Action will Be Undone!");
         icon:"info"
       }
     });
 }
 else {
   swal("Your imaginary file is safe!",{
icon:"error",
});

 }
});
}
//Death Alert
function DSalert(){
swal({
 title: "Are you sure?",
 text: "This  Patient Will Be Move,DeatList!",
 icon: "warning",
 buttons: true,
 dangerMode: true,
})
.then((willDelete) => {
 if (willDelete) {
   swal({
   title:"Okey Fine All The Details Fetch Now!",
   icon: "success",
   
   })
   .then((willRedirect) => {
       if (willRedirect) {
        window.location.href = "/DeathUpdate?deathPatientAaddharNo=" + patientAaadhrNumber + "&deathPatientName=" + patientName+"&deathPatientGender="+gender+"&deathPatientAge="+age+"&deathPatientMobileNo="+Mobilenumber+"&zoneName="+zoneareaname+"&municipalityId="+postcode+"&stateName="+stateName+"&resonForDeath="+otherHealthIssue;
        alert("SucessFully Added in DeathList")
       } else {
         swal("Ok this Action will Be Undone!");
         icon:"info"
       }
     });
 }
 else {
   swal("Your imaginary file is safe!",{
icon:"error",
});

 }
});
}
