export const loadToken = () => {
  const tokenDataString =
    typeof window !== "undefined" && localStorage.getItem("token");
  if (!tokenDataString) {
    return null;
  }
  const tokenData = JSON.parse(tokenDataString);
  const now = new Date();
  if (now.getTime() > tokenData.expires_in) {
    typeof window !== "undefined" && localStorage.removeItem("token");
    return null;
  }
  return tokenData.token;
};
