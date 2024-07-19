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