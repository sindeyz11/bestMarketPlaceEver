import { makeAutoObservable } from "mobx";
import { IUserRole } from "@/types";

export interface IAuthorizedUser {
  id?: number;
  role?: IUserRole;
  phone?: string;
  email?: string;
  username?: string;
  cardNumber?: string;
  CVC?: number;
  amountSpent?: number;
  orderCount?: number;
  validity?: any;
  userDiscount?: number;
  redemptionPercent?: number;
}

class AuthorizedUser {
  user: IAuthorizedUser | null = null;

  constructor() {
    makeAutoObservable(this);
    this.loadUser();
  }

  setUser(user: IAuthorizedUser) {
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
