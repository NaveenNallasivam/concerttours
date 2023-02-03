import { TreeNodeItem, TreeNodeItemDTO } from '../treeModule';
export interface EditableListNodeItemThumbnail {
    url: string;
}
export interface EditableListNodeItemDTO extends TreeNodeItemDTO {
    thumbnail?: EditableListNodeItemThumbnail;
    id: string;
    catalogVersion: string;
    catalogId: string;
}
export declare class EditableListNodeItem extends TreeNodeItem {
    thumbnail: EditableListNodeItemThumbnail;
    catalogVersion: string;
    catalogId: string;
    id: string;
    nodes: EditableListNodeItem[];
    parent: EditableListNodeItem;
    constructor(config: EditableListNodeItemDTO);
}
