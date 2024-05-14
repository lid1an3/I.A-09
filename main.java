import openai

class ChatBotIA:
    def _init_(self, api_key):
        self.api_key = api_key
        openai.api_key = api_key

    def perguntar(self, pergunta):
        try:
            resposta = openai.Completion.create(
              engine="davinci-codex",
              prompt=pergunta,
              temperature=0.7,
              max_tokens=50,
              top_p=1.0,
              frequency_penalty=0.0,
              presence_penalty=0.0,
              stop=["\n"]
            )
            return resposta.choices[0].text.strip()
        except Exception as e:
            return f"Erro ao perguntar: {str(e)}"

if _name_ == "_main_":
    api_key = "SUA_API_KEY_AQUI"
    agente = ChatBotIA(api_key)
    
    print("Bem-vindo ao ChatBotIA! Pode fazer perguntas.")
    print("Digite 'sair' para encerrar o programa.")
    
    while True:
        pergunta = input("Você: ")
        
        if pergunta.lower() == 'sair':
            print("Até mais!")
            break
