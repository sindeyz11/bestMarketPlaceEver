export const saveToken = (token: string) => {
  const now = new Date();
  const tokenData = {
    token: token,
    expires_in: now.getTime() + 24 * 60 * 60 * 1000,
  };
  localStorage.setItem("token", JSON.stringify(tokenData));
};
