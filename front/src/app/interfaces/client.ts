export interface ClientRequest{
    name: string;
    lastName: string;
    category: DocumentType;
    identificationNumber: number;
    email: string;
    businessName?: string;
}

export interface ClientResponse{
    id: number;
    name: string;
    lastName: string;
    category: DocumentType;
    identificationNumber: number;
    email: string;
    businessName?: string;
    //TODO agregar servicios vinculados, cuando esten disponibles
}

export enum DocumentType {
    DNI = 'DNI',
    CUIT = 'CUIT'
  }