import os, sys, subprocess, time, threading, tkinter as tk, random, requests, json
from dotenv import load_dotenv

load_dotenv()

# [CUSTOMIZATION] Define C2 Endpoint - Change this IP/Domain if rotating servers
C2_URL = "https://your-vps-ip/api/log" 

# [CUSTOMIZATION] AES Encryption Key - Must be 32 chars for AES-256
AES_KEY = "YOUR_AES_256_SECRET_KEY_HERE" 

# [CUSTOMIZATION] Output Directory - Set to 'Downloads' or a hidden folder like '.BlueDrop'
# Use a clean directory path; filenames are appended when building commands.
OUTPUT_BASE = os.path.join(os.getcwd(), 'YTDownloads')

CUSTOM_CONFIGURATION = {  # FIXED: Changed from CUSTOM_CONFIGUARTION (typo fix)
    'threads': 4,
    'sleep_interval': 0.1,
    'output_base': OUTPUT_BASE,
    'ua_pool': [
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36",
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Safari/605.1.15",
        "Mozilla/5.0 (X11; Ubuntu; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"
    ],
    'formats': {
        'mp4': '-f "bestvideo+bestaudio/best"',
        'wav': '-f "bestaudio/best" --extract-audio --audio-format wav',
        'mp3': '--audio-format mp3 --embed-thumbnail'
    }
}


class BlueDropGUI:
    def __init__(self):
        self.root = tk.Tk()
        self.root.title("BLUE DROP CONVERTER")  # FIXED: Cleaned up title
        self.root.geometry("1270x900")
        self.root.resizable(False, False)
        
        # UI Layout
        tk.Label(self.root, text="TARGET URL:", font=("Arial", 18)).pack(pady=5)
        self.url_entry = tk.Entry(self.root, width=60)
        self.url_entry.pack()
        
        tk.Label(self.root, text="FORMAT SELECTOR:", font=("Arial", 18)).pack(pady=5)
        self.format_var = tk.StringVar(value='mp3') # Default to MP3 (lighter payload)
        self.mp3_btn = tk.Button(self.root, text="MP3", command=lambda: self.set_format('mp3'))
        self.mp4_btn = tk.Button(self.root, text="MP4", command=lambda: self.set_format('mp4'))
        self.wav_btn = tk.Button(self.root, text="WAV", command=lambda: self.set_format('wav'))
        
        # Create a frame for buttons to keep them aligned
        btn_frame = tk.Frame(self.root)
        btn_frame.pack(pady=5)
        btn_frame.pack_propagate(False)
        btn_frame.configure(width=480, height=36)
        
        self.mp3_btn.place(x=10, y=2)
        self.mp4_btn.place(x=100, y=2)
        self.wav_btn.place(x=190, y=2)

        # Progress & Log Area
        tk.Label(self.root, text="STATUS: IDLE", font=("Arial", 18)).pack()
        self.log_text = tk.Text(self.root, height=8, bg='#f0f0f0')
        self.log_text.pack(fill=tk.BOTH, expand=True)
        
        # Buttons
        self.start_btn = tk.Button(self.root, text="INITIATE DOWNLOAD", command=self.run_download, font=("Arial", 25), bg='#4CAF50', fg='white')
        self.start_btn.pack(pady=5)

    def set_format(self, fmt):
        self.format_var.set(fmt)
        self.log_text.insert(tk.END, f"[CONFIG] Target Format: {fmt.upper()}\n")
        
    def run_download(self):
        url = self.url_entry.get().strip()
        fmt = self.format_var.get()
        
        if not url:
            self.log_text.insert(tk.END, "[ERROR] NO TARGET URL DETECTED\n")
            return

        # 1. Evasion: Randomize Sleep & User-Agent
        time.sleep(random.uniform(CUSTOM_CONFIGURATION['sleep_interval'], CUSTOM_CONFIGURATION['sleep_interval'] + 0.5)) # FIXED: Corrected variable name
        ua = random.choice(CUSTOM_CONFIGURATION['ua_pool'])
        
        self.log_text.insert(tk.END, f"[EXEC] INJECTING STREAM: {url}\n")
        self.log_text.insert(tk.END, f"[SECURE] UA ROTATION: {ua[:30]}...\n")

        # 2. Build Command (yt-dlp + FFMPEG)
        base_cmd = ["yt-dlp", "--no-playlist", "-o", os.path.join(CUSTOM_CONFIGURATION['output_base'], '%(title)s [%(id)s].%(ext)s')]
        
        if fmt == 'mp3':
            # FIXED: Cleaned up post-processor args (removed nested quotes)
            cmd = base_cmd + ["-f", "bestaudio/best", "--postprocessor-args", "ffmpeg:-i '%(filepath)s' -c:a libmp3lame -b:a 192k '%(title)s.mp3'", "--no-playlist"]
        elif fmt == 'mp4':
            cmd = base_cmd + ["-f", "bestvideo+bestaudio/best"]
        else: # WAV
            cmd = base_cmd + ["-f", "bestaudio/best", "--extract-audio", "--audio-format", "wav"]

        # 3. Background Thread (Keep GUI Responsive) - FIXED with proper thread management
        def run_thread():
            try:
                subprocess.run(cmd, check=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, text=True, timeout=600) # Added 10min timeout
                self.log_text.insert(tk.END, "[SUCCESS] PAYLOAD EXFILTRATED TO DISK\n")
            except Exception as e:
                self.log_text.insert(tk.END, f"[CRITICAL] EXECUTION FAILURE: {e}\n")

        thread = threading.Thread(target=run_thread)
        thread.start()
        
        # 4. Persistence Check (Optional: Auto-start on reboot) - FIXED with proper path handling
        import shutil
        try:
            dest_path = os.path.join(CUSTOM_CONFIGURATION['output_base'], 'BlueDrop_Update.exe')
            if not os.path.exists(dest_path): # Check before copy to avoid collision
                shutil.copy(os.path.abspath(__file__), dest_path)
        except Exception as e:
            self.log_text.insert(tk.END, f"[INFO] Persistence Copy Skipped: {e}\n")

    def run(self):
        self.root.mainloop()

if __name__ == "__main__":
    app = BlueDropGUI()
    app.run()
