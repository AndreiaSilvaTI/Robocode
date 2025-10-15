import pygame
import random

# Inicializar o Pygame
pygame.init()

# Definindo cores
PRETO = (0, 0, 0)
BRANCO = (255, 255, 255)
VERDE = (0, 255, 0)
AZUL = (0, 0, 255)
VERMELHO = (255, 0, 0)

# Configuração da janela
LARGURA = 800
ALTURA = 600
tela = pygame.display.set_mode((LARGURA, ALTURA))
pygame.display.set_caption('Bumblebee Battle')

# FPS
clock = pygame.time.Clock()

# Classe para o Robô Bumblebee
class RoboBumblebee(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = pygame.Surface((50, 50))
        self.image.fill(AZUL)
        self.rect = self.image.get_rect()
        self.rect.center = (LARGURA // 2, ALTURA - 50)
        self.velocidade = 5

    def update(self, teclas):
        if teclas[pygame.K_LEFT] and self.rect.left > 0:
            self.rect.x -= self.velocidade
        if teclas[pygame.K_RIGHT] and self.rect.right < LARGURA:
            self.rect.x += self.velocidade
        if teclas[pygame.K_UP] and self.rect.top > 0:
            self.rect.y -= self.velocidade
        if teclas[pygame.K_DOWN] and self.rect.bottom < ALTURA:
            self.rect.y += self.velocidade

# Classe para os inimigos
class Inimigo(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = pygame.Surface((50, 50))
        self.image.fill(VERMELHO)
        self.rect = self.image.get_rect()
        self.rect.x = random.randint(0, LARGURA - 50)
        self.rect.y = random.randint(-100, -40)
        self.velocidade = random.randint(1, 4)

    def update(self):
        self.rect.y += self.velocidade
        if self.rect.top > ALTURA:
            self.rect.x = random.randint(0, LARGURA - 50)
            self.rect.y = random.randint(-100, -40)

# Função para desenhar o texto na tela
def desenhar_texto(texto, cor, posicao):
    fonte = pygame.font.SysFont("Arial", 30)
    texto_superior = fonte.render(texto, True, cor)
    tela.blit(texto_superior, posicao)

# Função principal do jogo
def jogo():
    # Criando o grupo de sprites
    todos_sprites = pygame.sprite.Group()
    inimigos = pygame.sprite.Group()

    # Criando o Bumblebee
    bumblebee = RoboBumblebee()
    todos_sprites.add(bumblebee)

    # Criando os inimigos
    for _ in range(5):
        inimigo = Inimigo()
        todos_sprites.add(inimigo)
        inimigos.add(inimigo)

    rodando = True
    while rodando:
        # Verificar eventos
        for evento in pygame.event.get():
            if evento.type == pygame.QUIT:
                rodando = False

        # Atualizar o jogo
        teclas = pygame.key.get_pressed()
        todos_sprites.update(teclas)

        # Verificar colisão entre Bumblebee e inimigos
        colisao_inimigos = pygame.sprite.spritecollide(bumblebee, inimigos, True)
        if colisao_inimigos:
            desenhar_texto("Batalha perdida!", VERMELHO, (LARGURA // 3, ALTURA // 3))
            pygame.display.update()
            pygame.time.delay(2000)
            rodando = False

        # Desenhar
        tela.fill(PRETO)
        todos_sprites.draw(tela)
        desenhar_texto("Bumblebee Battle", BRANCO, (LARGURA // 3, 20))

        # Atualizar a tela
        pygame.display.update()

        # Controlar a taxa de FPS
        clock.tick(60)

    # Fechar o Pygame
    pygame.quit()

# Iniciar o jogo
jogo()
