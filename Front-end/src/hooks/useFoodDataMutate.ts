import { useMutation } from "@tanstack/react-query";
import axios, { AxiosResponse } from "axios";
import { FoodData } from "../interface/FoodData";

const API_URL = "http://localhost:8080";

// Função para fazer o POST
const postFoodData = async (foodData: FoodData): Promise<AxiosResponse> => {
  const response = await axios.post(`${API_URL}/food`, foodData);
  return response;
};

// Hook personalizado para a mutação
export function useFoodDataMutate() {
  // Tipagem correta para o useMutation
  const mutation = useMutation<AxiosResponse, Error, FoodData>({
    mutationFn: postFoodData,
  });

  return mutation; // Retorna a mutação com todas as propriedades
}
