import { IUserRole } from "@/types";
import { makeAutoObservable } from "mobx";

interface IUser {
  user_id: number;
  token: string;
  role: IUserRole;
}

class AuthorizedUser {
  user: IUser | null = null

  constructor() {
    makeAutoObservable(this);
    this.loadUser();
  }

  setUser(user: IUser) {
    this.user = user;
    this.saveUser();
  }

  saveUser() {
    if (this.user) {
      localStorage.setItem("user", JSON.stringify(this.user));
    } else {
      localStorage.removeItem("user");
    }
  }

  loadUser() {
    const userData =
      typeof window !== "undefined" ? localStorage.getItem("user") : null;
    if (userData) {
      this.user = JSON.parse(userData);
    }
    return this.user;
  }

  logout() {
    
    this.user = null;
    this.saveUser();
    localStorage.removeItem("user");
    localStorage.removeItem("token");
  }
}

const authorizedUserStore = new AuthorizedUser();
export default authorizedUserStore;
