function readyfun() {

	var dataView;
	var grid;
	var columnFilters = {};
	var data = document.getElementById("myDiv").value;
	console.log(data);
	//var data=data1.split('},');

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
	var actions = function(row, cell, value, columnDef, dataContext) {
		let phoneNo = dataContext.mobileNo;
		console.log(phoneNo);
		let patientName = dataContext.patientName;
		console.log(patientName);
		return `<button onclick="messageFunction(` + phoneNo + `,'` + patientName + `')">Send Message</button>`
	}
	// Use the updated items array list with unique ids
	console.log(data1);
	/* unique id end */
	var options = {
		enableCellNavigation: true,
		showHeaderRow: true,
		headerRowHeight: 30,
		explicitInitialization: true
	};
	var columnFilters = {};

	var columns = [{
		id: "positiveId",
		name: "Positive Code",
		field: "positiveId",
		sortable: true,
	}, {
		id: "patientName",
		name: "Patient Name",
		field: "patientName",
		sortable: true,
	}, {
		id: "mobileNo",
		name: " Phone No.",
		field: "mobileNo",
		sortable: true,
	}, {
		id: "testResult",
		name: " Tets Report.",
		field: "testResult",
		sortable: true,
	},
	{
		id: "sendMessage",
		name: "Send message",
		field: "sendMessage",
		sortable: true,
		formatter: actions
	}];

	/* filter start */
	$(function() {
		function filter(item) {
			for (var columnId in columnFilters) {
				if (columnId !== undefined
					&& columnFilters[columnId] !== "") {
					var c = grid.getColumns()[grid.getColumnIndex(columnId)];
					if (item[c.field] != columnFilters[columnId]) {
						return false;
					}
				}
			}
			return true;
		}
		dataView = new Slick.Data.DataView();
		grid = new Slick.Grid("#myGrid", dataView, columns, options);
		/* filter start */
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
		grid.init();

		dataView.beginUpdate();
		dataView.setItems(data1);
		dataView.setFilter(filter);
		dataView.endUpdate();
	})
	/* filter end */


}
//let patientName=document.getElementById('alertName').value;

async function messageFunction(mobNo, name) {


	console.log(mobNo);
	console.log(name);
	let response = await fetch("http://localhost:8080/sendSms?mobileNumber=" + mobNo + "&name=" + name, { method: "POST" });
	var personDetails = await fetchDetails(response);

}
function fetchDetails(response) {
	return new Promise((resolve, reject) => {
		response.text().then((data) => {
			alert(data);
		})
	})

}

