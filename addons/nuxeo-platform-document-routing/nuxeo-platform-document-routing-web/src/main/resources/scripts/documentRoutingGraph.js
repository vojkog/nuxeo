//jsPlumb options
var arrowCommon = {
	foldback : 0.7,
	fillStyle : "#F78181",
	width : 8
};

var overlays = [ [ "Arrow", {
	location : 0.7
}, arrowCommon ] ];

function getConnectionOverlayLabel() {
	return {
		connector : [ "Flowchart", {
			stub : 20
		} ],
		overlays : overlays,
		anchors : [ "TopCenter" ]
	};
};

function sourceEndpointOptions() {
	return {
		isSource : true,
		connectorStyle : {
			strokeStyle : "#F78181"
		},
		anchor : [ 0.5, 1, 0, 1 ],
		connector : [ "StateMachine", {
			curviness:20,
			proximityLimit:200,
			margin:10,
			loopbackRadius: 40
		} ],
		isTarget : false,
		uniqueEndpoint : true
	};
};

function jsPlumbInitializeDefault() {
	jsPlumb.importDefaults({
		PaintStyle : {
			strokeStyle : "#F78181",
			lineWidth : 2
		},
		Endpoint : [ "Dot", {
			radius : 4
		} ]
	});
};
// --> end jsPlumbOptions
// display graph
function displayGraph(data) {
	jQuery.each(data['nodes'], function() {
		var node = '<div class="node" id="' + this.id + '">' + this.title
				+ '</div>';
		var x = (this.x - 100)<=10?this.x:(this.x - 100);
		jQuery(node).appendTo('#target').css('left', x).css('top',
				this.y).addClass('node_' + this.state);
		jsPlumb.makeSource(this.id, sourceEndpointOptions());
	});

	jQuery.each(data['transitions'], function() {
		jsPlumb.connect({
			source : this.nodeSourceId,
			target : this.nodeTargetId
		}, getConnectionOverlayLabel());
	});
};

function invokeGetGraphOp(routeId) {
	var ctx = {
		currentDocument : '#{currentDocument.id}',
		conversationId : '#{org.jboss.seam.core.manager.currentConversationId}',
		lang : '#{localeSelector.localeString}',
		repository : '#{currentDocument.repositoryName}'
	};

	var getGraphNodesExec = jQuery().automation('Document.Routing.GetGraph');
	getGraphNodesExec.setContext(ctx);
	getGraphNodesExec.addParameter("routeDocId", routeId);
	getGraphNodesExec.executeGetBlob(function(data, status, xhr) {
		displayGraph(data);
	}, function(xhr, status, errorMessage) {
		jQuery('<div>Can not load graph </div>').appendTo('#target');
	}, true);
};

function loadGraph(routeDocId) {
	jsPlumbInitializeDefault();
	invokeGetGraphOp(routeDocId);
};