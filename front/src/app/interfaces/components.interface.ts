export interface Column {
    field: string;
    header: string;
    sortable?: boolean;
}

export interface FormField{
    label: string; 
    controlName: string; 
    type: TypeField;
    errorMessage: string;
    placeholder?: string;
    validators?: any[];
    selectList? : any[];
    classList?: string;
}

export enum TypeField{
    TEXT = 'text',
    NUMBER = 'number',
    SELECT = 'select'
}

export interface CustomPage<T> {
    content: T[];
    pageNumber: number;
    pageSize: number;
    totalPages: number;
    totalElements: number;
    first: boolean;
    last: boolean;
    numberOfElements: number;
}

export interface PageParams {
    page: number;
    size: number;
    sort?: string;
}
