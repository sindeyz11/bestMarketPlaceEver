import { loadToken } from "@/utils/load-token";
import { useQuery } from "@tanstack/react-query";
import UserService from "@/app/api/user-service";

export const useAuth = () => {
  const token = loadToken();
  const user_id = token ? token.user_id : null;

  const { data, isLoading, isError, error, isStale } = useQuery({
    queryKey: ["user", user_id],
    queryFn: async () => {
      if (!user_id) {
        throw new Error("User ID не найден");
      }
      const { data } = await UserService.getAllUserInfo(user_id);
      return data;
    },
    enabled: !!user_id, 
    staleTime: Infinity,
    refetchOnWindowFocus: true, 
  });

  return { data, isLoading, isError, error, isStale };
};