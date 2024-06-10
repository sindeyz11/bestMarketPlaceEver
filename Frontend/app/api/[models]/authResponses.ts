export interface AuthResponse {
    role: string;
    token: string;
}

export interface RegisterResponse extends AuthResponse {}