/* Place any Javascript here you want loaded in test.xhtml */

PrimeFaces.widget.DataTable.prototype.showCellEditor = function(c) {
    this.incellClick = true;

    var cell = null;

    if (c) {
        cell = c;

        //remove contextmenu selection highlight
        if (this.contextMenuCell) {
            this.contextMenuCell.parent().removeClass('ui-state-highlight');
        }
    } else {
        cell = this.contextMenuCell;
    }

    var editorInput = cell.find('> .ui-cell-editor > .ui-cell-editor-input');
    if (editorInput.length !== 0 && editorInput.children().length === 0 && this.cfg.editMode === 'cell') {
        // for lazy cellEditMode
        this.cellEditInit(cell);
    } else {
        this.showCurrentCell(cell);

        if (this.hasBehavior('cellEditInit')) {
            var cellInfo = this.getCellMeta(cell);
            if (cellInfo.indexOf('undefined') === -1) {
                var ext = {
                    params: [{
                        name: this.id + '_cellInfo',
                        value: cellInfo
                    }]
                };
                this.callBehavior('cellEditInit', ext);
            }
        }
    }
};