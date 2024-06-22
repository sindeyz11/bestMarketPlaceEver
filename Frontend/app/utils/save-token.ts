import { IUserRole } from "@/types";

export const saveToken = (token: string, user_id: number, role: IUserRole) => {
  const now = new Date();
  const tokenData = {
    user_id,
    role,
    token: token,
    expires_in: now.getTime() + 24 * 60 * 60 * 1000,
  };
  localStorage.setItem("token", JSON.stringify(tokenData));
};
